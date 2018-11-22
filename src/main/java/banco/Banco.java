package banco;

import java.util.List;
import java.util.stream.Collectors;

public class Banco {
    private List<CuentaBancaria> cuentaBancarias;

    public List<CuentaBancaria> cuentasConSaldoNegativo(){
        return cuentaBancarias.stream().filter(c -> c.getSaldo() < 0).collect(Collectors.toList());
    }
}
