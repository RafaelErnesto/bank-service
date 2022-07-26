package quarkus.bank;

import io.quarkus.arc.config.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Optional;

@Path("/bank")
public class BankResource {

    @ConfigProperty(name="bank.name")
    String name;

    @ConfigProperty(name="bank.mobileBanking")
    Optional<Boolean>  mobileBanking;

    @Inject
    BankSupportConfig bankSupportConfig;

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String getName() {
        return name;
    }

    @GET
    @Path("/mobilebanking")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean getMobileBanking() {
        return mobileBanking.orElse(false);
    }

    @GET
    @Path("/support")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, String> getSupport() {
        HashMap<String, String> map = new HashMap<>();

        map.put("email", bankSupportConfig.email);
        map.put("phone", bankSupportConfig.getPhone());

        return map;
    }
}