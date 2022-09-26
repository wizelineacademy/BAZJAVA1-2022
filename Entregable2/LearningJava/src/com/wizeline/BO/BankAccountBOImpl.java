package com.wizeline.BO;

import com.wizeline.DTO.BankAccountDTO;
import com.wizeline.ENUMS.Country;
import com.wizeline.Entities.Notificacion;
import com.wizeline.Entities.NotificacionFactory;
import com.wizeline.utils.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankAccountBOImpl implements BankAccountBO {
        @Override
        public List<BankAccountDTO> getAccounts() {
            //Fabrica de metodos
            NotificacionFactory accountFactory = new NotificacionFactory();
            // Definicion de lista con la informacion de las cuentas existentes.
            List<BankAccountDTO> accountDTOList = new ArrayList<>();

            accountDTOList.add(buildBankAccount("user3@wizeline.com", true, Country.MX,obtenerFechaConsulta()));
            Notificacion account = accountFactory.createAccount("ADVANCE");
            account.notificaCreacion();

            accountDTOList.add(buildBankAccount("user1@wizeline.com", Country.FR));
            account = accountFactory.createAccount("BASIC");
            account.notificaCreacion();

            accountDTOList.add(buildBankAccount("user2@wizeline.com" ,false, Country.US, obtenerFechaConsulta()));
            account = accountFactory.createAccount("ADVANCE");
            account.notificaCreacion();
            return accountDTOList;
        }

        @Override
        public BankAccountDTO getAccountDetails(String user, String lastUsage) {
            DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate usage = LocalDate.parse(lastUsage, dateformatter);
            return buildBankAccount(user, true, Country.MX, usage.atStartOfDay());
        }

    // Creación de tipo de dato BankAccount
    private BankAccountDTO buildBankAccount(String user, boolean isActive, Country country, LocalDateTime lastUsage) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setAccountNumber(Utils.randomAccountNumber());
        bankAccountDTO.setAccountName("Dummy Account ".concat(Utils.randomInt()));
        bankAccountDTO.setUser(user);
        bankAccountDTO.setAccountBalance(Utils.randomBalance());
        bankAccountDTO.setAccountType(Utils.pickRandomAccountType());
        bankAccountDTO.setCountry(Utils.getCountry(country));
        bankAccountDTO.setAccountActive(isActive);
        bankAccountDTO.getLastUsage();
        bankAccountDTO.setCreationDate(lastUsage);
        bankAccountDTO.setAccountActive(isActive);

        return bankAccountDTO;
    }
    //SOBRECARGA DE METODO
    private BankAccountDTO buildBankAccount(String user, Country country) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setAccountNumber(Utils.randomAccountNumber());
        bankAccountDTO.setAccountName("Dummy Account ".concat(Utils.randomInt()));
        bankAccountDTO.setUser(user);
        bankAccountDTO.setAccountBalance(Utils.randomBalance());
        bankAccountDTO.setAccountType(Utils.pickRandomAccountType());
        bankAccountDTO.setCountry(Utils.getCountry(country));
        bankAccountDTO.setAccountActive(false);
        bankAccountDTO.getLastUsage();
        bankAccountDTO.setCreationDate(LocalDateTime.now());

        return bankAccountDTO;
    }
    private LocalDateTime obtenerFechaConsulta(){
            return LocalDateTime.now().minusDays(7);
    }
}
