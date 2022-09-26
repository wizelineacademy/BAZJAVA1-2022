package com.wizeline;

import com.wizeline.Exceptions.ExcepcionGenerica;
import com.sun.net.httpserver.HttpServer;
import com.wizeline.BO.BankAccountBO;
import com.wizeline.BO.BankAccountBOImpl;
import com.wizeline.BO.UserBO;
import com.wizeline.BO.UserBOImpl;
import com.wizeline.DTO.BankAccountDTO;
import com.wizeline.DTO.ResponseDTO;
import com.wizeline.DTO.UserDTO;
import com.wizeline.Exceptions.ExcepcionNoBody;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.function.Function;

public class LearningJava extends Thread {
    private static final Logger LOGGER = Logger.getLogger(LearningJava.class.getName());
    private static String SUCCES_CODE = "0K000";
    private static String responseTextThread = "";
    private ResponseDTO response;
    private static String textThread = "";

    public static void main(String[] args) throws IOException {
        LOGGER.info("LearningJava - Iniciado servicio REST ...");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        String msgProcPeticion = "LearningJava - Inicia procesamiento de peticion ...";

        //----------------------------CREAR USUARIOS-------------------------------------
        server.createContext("/api/createUsers", (exchange -> {
            LOGGER.info(msgProcPeticion);
            ResponseDTO response = new ResponseDTO();
            /** Validates the type of http request  */
            exchange.getRequestBody();
            if ("POST".equals(exchange.getRequestMethod())) {
                LOGGER.info("LearningJava - Procesando peticion HTTP de tipo POST");

                // Obtenemos el request del body que mandamos
                StringBuilder text = new StringBuilder();
                try (Scanner scanner = new Scanner(exchange.getRequestBody())) {
                    while(scanner.hasNext()) {
                        text.append(scanner.next());
                    }
                } catch (Exception e) {
                    LOGGER.severe(e.getMessage());
                    throw new ExcepcionNoBody();
                }
                textThread = text.toString();

                LOGGER.info(textThread);

                // Iniciamos 3 hilos
                LearningJava thread1 = new LearningJava();
                LearningJava thread2 = new LearningJava();
                LearningJava thread3 = new LearningJava();
                thread1.start();
                thread2.start();
                thread3.start();

                // Esperamos a que terminen
                while(thread1.isAlive());
                while(thread2.isAlive());
                while(thread3.isAlive());

                exchange.getResponseHeaders().set("contentType", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(200, responseTextThread.getBytes().length);
            } else {
                /** 405 Method Not Allowed */
                exchange.sendResponseHeaders(405, -1);
            }
            OutputStream output = exchange.getResponseBody();
            /**
             * Always remember to close the resources you open.
             * Avoid memory leaks
             */
            LOGGER.info("LearningJava - Cerrando recursos ...");
            output.write(responseTextThread.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));

        //-------------------------------LOGIN------------------------------------------
        server.createContext("/api/login", (exchange -> {
            LOGGER.info("LearningJava - Inicia procesamiento de peticion ...");
            ResponseDTO response = new ResponseDTO();
            String responseText = "";
            /** Validates the type of http request  */
            if ("GET".equals(exchange.getRequestMethod())) {
                LOGGER.info("LearningJava - Procesando peticion HTTP de tipo GET");
                UserDTO user =  new UserDTO();
                user = user.getParameters(splitQuery(exchange.getRequestURI()));

                //EXPRESION REGULAR CORREO ELECTRONICO
                Pattern pat = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
                Matcher mat = pat.matcher(user.getUser());
                if (mat.matches()) {
                    response = login(user.getUser(), user.getPassword());
                    if(response.getCode().equals(SUCCES_CODE)) {
                        JSONObject json = new JSONObject(response);
                        responseText = json.toString();
                        exchange.getResponseHeaders().set("contentType", "application/json; charset=UTF-8");
                        exchange.sendResponseHeaders(200, responseText.getBytes().length);
                    }
                    else {
                        exchange.sendResponseHeaders(404,-1);
                    }
                } else {
                    responseText = "No es un correo valido";
                    exchange.sendResponseHeaders(404,responseText.getBytes().length);
                }

            } else {
                /** 405 Method Not Allowed */
                exchange.sendResponseHeaders(405, -1);
            }
            OutputStream output = exchange.getResponseBody();
            /**
             * Always remember to close the resources you open.
             * Avoid memory leaks
             * */
            LOGGER.info("LearningJava - Cerrando recursos ...");
            output.write(responseText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));

        //----------------------------CREAR USUARIO---------------------------------
        server.createContext("/api/createUser", (exchange -> {
            LOGGER.info("LearningJava - Inicia procesamiento de peticion ...");
            ResponseDTO response = new ResponseDTO();
            String responseText = "";
            /** Validates the type of http request  */
            exchange.getRequestBody();
            if ("POST".equals(exchange.getRequestMethod())) {
                LOGGER.info("LearningJava - Procesando peticion HTTP de tipo POST");
                UserDTO user =  new UserDTO();
                user = user.getParameters(splitQuery(exchange.getRequestURI()));
                response = createUser(user.getUser(), user.getPassword());
                JSONObject json = new JSONObject(response);
                responseText = json.toString();
                exchange.getResponseHeaders().set("contentType", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
            } else {
                /** 405 Method Not Allowed */
                exchange.sendResponseHeaders(405, -1);
            }
            OutputStream output = exchange.getResponseBody();
            /**
             * Always remember to close the resources you open.
             * Avoid memory leaks
             */
            LOGGER.info("LearningJava - Cerrando recursos ...");
            output.write(responseText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));

        //--------------------------OBTENER CUENTAS-------------------------------------
        server.createContext("/api/getAccounts", (exchange -> {
            LOGGER.info("LearningJava - Inicia procesamiento de peticion ...");
            LocalDateTime init = LocalDateTime.now(); //<--- tiempo inicial

            BankAccountBO bankAccountBO = new BankAccountBOImpl();
            String responseText = "";
            /** Validates the type of http request  */
            if ("GET".equals(exchange.getRequestMethod())) {
                LOGGER.info("LearningJava - Procesando peticion HTTP de tipo GET");
                List<BankAccountDTO> accounts = bankAccountBO.getAccounts();
                JSONArray json = new JSONArray(accounts);
                responseText = json.toString();
                exchange.getResponseHeaders().add("Content-type", "application/json");
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
            } else {
                /** 405 Method Not Allowed */
                exchange.sendResponseHeaders(405, -1);
            }
            OutputStream output = exchange.getResponseBody();

            LocalDateTime fin = LocalDateTime.now(); //<--- tiempo final

            Long duration = Duration.between(init, fin).toMillis();
            double tiempoEjec = (double) duration/1000;
            String total = new String(String.valueOf(tiempoEjec).concat(" Segundos"));
            LOGGER.info("Tiempo de respuesta: ".concat(total));
            /**
             * Always remember to close the resources you open.
             * Avoid memory leaks
             */
            LOGGER.info("LearningJava - Cerrando recursos ...");
            output.write(responseText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));

        //------------------------------AGRUPACION DE CUENTAS-----------------------------------------------
        // Consultar todas las cuentas y agruparlas por su tipo utilizando Programación Funcional
        server.createContext("/api/getAccountsGroupByType", (exchange -> {
            LOGGER.info(msgProcPeticion);
            Instant inicioDeEjecucion = Instant.now();
            BankAccountBO bankAccountBO = new BankAccountBOImpl();
            String responseText = "";
            /** Validates the type of http request  */
            if ("GET".equals(exchange.getRequestMethod())) {
                LOGGER.info("LearningJava - Procesando peticion HTTP de tipo GET");
                List<BankAccountDTO> accounts = bankAccountBO.getAccounts();

                // Uso de por lo menos 2 operaciones intermedias y 2 tipos de colectores
                Map<String, List<BankAccountDTO>> groupedAccounts;
                Function<BankAccountDTO, String> groupFunction = (account) -> account.getAccountType().toString();
                groupedAccounts = accounts.stream().distinct().limit(10).collect(Collectors.groupingBy(groupFunction));
                Long numeroCuentas = accounts.stream().collect(Collectors.counting());


                JSONObject json = new JSONObject(groupedAccounts);
                responseText = json.toString().concat("Numero de cuentas: "+numeroCuentas);
                exchange.getResponseHeaders().add("Content-type", "application/json");
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
            } else {
                /** 405 Method Not Allowed */
                exchange.sendResponseHeaders(405, -1);
            }
            OutputStream output = exchange.getResponseBody();
            Instant finalDeEjecucion = Instant.now();
            /**
             * Always remember to close the resources you open.
             * Avoid memory leaks
             */
            LOGGER.info("LearningJava - Cerrando recursos ...");
            String total = new String(String.valueOf(Duration.between(inicioDeEjecucion, finalDeEjecucion).toMillis()).concat(" segundos."));
            LOGGER.info("Tiempo de respuesta: ".concat(total));
            output.write(responseText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));

        //-----------------------OBTENER CUENTA DE UN USUARIO--------------------------------------
        server.createContext("/api/getUserAccount", (exchange -> {
            LOGGER.info("LearningJava - Inicia procesamiento de peticion ...");

            LocalDateTime init = LocalDateTime.now();

            ResponseDTO response = new ResponseDTO();
            String responseText = "";
            /** Validates the type of http request  */
            if ("GET".equals(exchange.getRequestMethod())) {
                LOGGER.info("LearningJava - Procesando peticion HTTP de tipo GET");
                UserDTO user =  new UserDTO();
                Map<String, String> params = splitQuery(exchange.getRequestURI());
                user = user.getParameters(params);
                // Valida formato del parametro fecha (date) [dd-mm-yyyy]
                String lastUsage = params.get("date");
                response = login(user.getUser(), user.getPassword());
                            BankAccountBOImpl bankAccountBO = new BankAccountBOImpl();
                            BankAccountDTO bankAccountDTO = bankAccountBO.getAccountDetails(user.getUser(), lastUsage);
                            JSONObject json = new JSONObject(bankAccountDTO);
                            responseText = json.toString();
                            exchange.getResponseHeaders().add("Content-type", "application/json");
                            exchange.sendResponseHeaders(200, responseText.getBytes().length);
            } else {
                /** 405 Method Not Allowed */
                exchange.sendResponseHeaders(405, -1);
            }
            OutputStream output = exchange.getResponseBody();
            LocalDateTime fin = LocalDateTime.now();
            /**
             * Always remember to close the resources you open.
             * Avoid memory leaks
             */
            LOGGER.info("LearningJava - Cerrando recursos ...");
            String total = new String(String.valueOf(Duration.between(init, fin).toMillis()).concat(" segundos."));
            LOGGER.info("Tiempo de respuesta: ".concat(total));
            output.write(responseText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));

        /** creates a default executor */
        server.setExecutor(null);
        server.start();
        LOGGER.info("LearningJava - Server started on port 8080");
    }

    @SuppressWarnings("unchecked")
    public static Map<String,String> splitQuery(URI uri) throws UnsupportedEncodingException{
        Map<String,String> query_pairs = new LinkedHashMap<>();
        String query = uri.getQuery();
        String[] pairs = query.split("&");
        for (String pair: pairs){
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0,idx), "UTF-8"),URLDecoder.decode(pair.substring(idx+1),"UTF-8"));
        }
        return query_pairs;
    }


    private static ResponseDTO login(String user, String password){
        UserBO userBO = new UserBOImpl();
        return userBO.login(user,password);
    }

    private static ResponseDTO createUser(String user, String password){
        UserBO userBO = new UserBOImpl();
        return  userBO.createUser(user,password);
    }
    @Override
    public void run(){
        try {
            crearUsuarios();
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new ExcepcionGenerica(e.getMessage());
        }
    }

    @Deprecated(since = "Anotaciones update") //since JAVA 11 nivel 9
    private void createUsers() {
        try {
            String user = "user";
            String pass = "password";
            JSONArray jsonArray = new JSONArray(textThread);
            JSONObject user1 = new JSONObject(jsonArray.get(0).toString());
            JSONObject user2 = new JSONObject(jsonArray.get(1).toString());
            JSONObject user3 = new JSONObject(jsonArray.get(2).toString());

            ResponseDTO response = createUser(user1.getString(user), user1.getString(pass));
            responseTextThread = new JSONObject(response).toString();
            LOGGER.info("Usuario 1: " + responseTextThread);
            Thread.sleep(1000);

            response = createUser(user2.getString(user), user2.getString(pass));
            responseTextThread = new JSONObject(response).toString();
            LOGGER.info("Usuario 2: " + responseTextThread);
            Thread.sleep(1000);

            response = createUser(user3.getString(user), user3.getString(pass));
            responseTextThread = new JSONObject(response).toString();
            LOGGER.info("Usuario 3: " + responseTextThread);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void crearUsuarios() {
        try {
            String user = "user";
            String pass = "password";
            JSONArray jsonArray = new JSONArray(textThread);
            JSONObject userJson;

            ResponseDTO response = null;

            LOGGER.info("jsonArray.length(): " + jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++) {
                userJson = new JSONObject(jsonArray.get(i).toString());
                response = createUser(userJson.getString(user), userJson.getString(pass));
                responseTextThread = new JSONObject(response).toString();
                LOGGER.info("Usuario " + (i+1) + ": " + responseTextThread);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
