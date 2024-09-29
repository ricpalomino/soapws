package pe.idat.repositorio;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import jakarta.annotation.PostConstruct;
import pe.idat.ws.*;
import java.util.*;

@Component
public class PaisRepositorio {
	
	public static final Map<String, Pais> paises = new HashMap<>();
    
    @PostConstruct
    public void initData() {
        Pais peru = new Pais();
        peru.setNombre("Peru");
        peru.setCapital("Lima");
        peru.setPoblacion(33000000);
        peru.setMoneda(Moneda.SOL);
        paises.put(peru.getNombre(), peru);
        
        Pais ecuador = new Pais();
        ecuador.setNombre("Ecuador");
        ecuador.setCapital("Guayaquil");
        ecuador.setPoblacion(33000000);
        ecuador.setMoneda(Moneda.DOLAR);
        paises.put(ecuador.getNombre(), ecuador);
        
        Pais mexico = new Pais();
        mexico.setNombre("Venezuela");
        mexico.setCapital("Venezuela");
        mexico.setPoblacion(12000000);
        mexico.setMoneda(Moneda.BOLIVAR);
        paises.put(mexico.getNombre(), mexico);
    }
    
    public Pais buscarPais(String nombre) {
        Assert.notNull(nombre, "El nombre del pais no puede ser nulo");
        return paises.get(nombre);
    }
	
}
