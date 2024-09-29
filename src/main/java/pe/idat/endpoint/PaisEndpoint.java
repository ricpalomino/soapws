package pe.idat.endpoint;

import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pe.idat.repositorio.PaisRepositorio;
import pe.idat.ws.GetPaisRequest;
import pe.idat.ws.GetPaisResponse;
import pe.idat.ws.GetPaisesRequest;
import pe.idat.ws.GetPaisesResponse;
import pe.idat.ws.Pais;

@Endpoint
public class PaisEndpoint {

    private static final String NAMESPACE_URI = "http://idat.pe/ws";

    private PaisRepositorio paisRepositorio;

    public PaisEndpoint(PaisRepositorio repositorio){
        this.paisRepositorio = repositorio;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
    @ResponsePayload
    public GetPaisResponse getCountry(@RequestPayload GetPaisRequest request) {
        GetPaisResponse response = new GetPaisResponse();
        response.setPais(paisRepositorio.buscarPais(request.getNombre()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisesRequest")
    @ResponsePayload
    public GetPaisesResponse getCounties(@RequestPayload GetPaisesRequest request) {
        GetPaisesResponse paisesResponse = new GetPaisesResponse();
        List<Pais> paises = (List<Pais>) PaisRepositorio.paises.values().stream().toList();
        paisesResponse.getPaises().addAll(paises);
        return paisesResponse;
    }


}
