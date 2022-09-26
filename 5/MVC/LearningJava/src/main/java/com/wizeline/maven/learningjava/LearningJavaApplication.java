package com.wizeline.maven.learningjava;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.wizeline.maven.learningjava.utils.Utils.isDateFormatValid;
import static com.wizeline.maven.learningjava.utils.Utils.isPasswordValid;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import com.wizeline.maven.learningjava.model.BankAccountDTO;
import com.wizeline.maven.learningjava.model.ResponseDTO;
import com.wizeline.maven.learningjava.model.UserDTO;
import com.wizeline.maven.learningjava.service.BankAccountService;
import com.wizeline.maven.learningjava.service.BankAccountServiceImpl;
import com.wizeline.maven.learningjava.service.UserService;
import com.wizeline.maven.learningjava.service.UserServiceImpl;
import com.wizeline.maven.learningjava.utils.exceptions.ExcepcionGenerica;

@SpringBootApplication
public class LearningJavaApplication extends Thread {

	private static final Logger LOGGER = Logger.getLogger(LearningJavaApplication.class.getName());

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LearningJavaApplication.class, args);
		LOGGER.info("LearningJava - Iniciado servicio REST ...");
	}

}
