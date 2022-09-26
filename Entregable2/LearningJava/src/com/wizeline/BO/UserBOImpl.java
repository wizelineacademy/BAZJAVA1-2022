package com.wizeline.BO;

import com.wizeline.DAO.UserDAO;
import com.wizeline.DAO.UserDAOImpl;
import com.wizeline.DAO.UserObjectDAO;
import com.wizeline.DTO.ErrorDTO;
import com.wizeline.DTO.ResponseDTO;
import com.wizeline.Entities.User;
import com.wizeline.utils.Utils;

import java.util.logging.Logger;

public class UserBOImpl implements UserBO{
    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public ResponseDTO createUser(String user, String password) {
        LOGGER.info("Inicia procesamiento en capa de negocio");
        ResponseDTO response = new ResponseDTO();
        String result = "fail";
        if (Utils.validateNullValue(user) && Utils.validateNullValue(password)){

            UserObjectDAO userObjectDAO= new UserDAOImpl();//Uso de interfaz propia
            User userObject = new User.UserBuilder().user(user).pass(password).administrador(false).tipo(Utils.pickRandomUserType()).build(); //Instancia objeto propio USER
            result = userObjectDAO.createUser(userObject);

            response.setCode("0K000");
            response.setStatus(result);
        }else {
            response.setCode("ERR00");
            response.setStatus(result);
            response.setErrors(new ErrorDTO("ER001","Error al crear usuario"));
        }
        return response;
    }

    @Override
    public ResponseDTO login(String user, String password) {
        LOGGER.info("Inicia procesamiento en capa de negocio");
        ResponseDTO response = new ResponseDTO();
        String result = "";
        if (Utils.validateNullValue(user) && Utils.validateNullValue(password)){
            UserDAO userDAO = new UserDAOImpl();
            result = userDAO.login(user,password);
        }
        if ("success".equals(result)){
            response.setCode("0K000");
            response.setStatus(result);
        }else {
            response.setCode("ER001");
            response.setErrors(new ErrorDTO("ER001",result));
            response.setStatus("fail");
        }
        return response;
    }
}
