package os.expert.demo.helidon;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

import java.util.List;

@Path("/beers")
@RequestScoped
public class BeerResource {


    @Inject
    private BeerRepository beerRepository;


    @GET
    public List<Beer> getBeers() {
        return beerRepository.findAll().toList();
    }
}
