package os.expert.demo.helidon;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

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

    @GET
    @Path("{id}")
    public Beer getBeerById(@PathParam("id") String id) {
        return beerRepository.findById(id)
                .orElseThrow(() -> new WebApplicationException("Beer not found: " + id, Response.Status.NOT_FOUND));
    }

    @PUT
    public void insert(Beer beer) {
        beerRepository.save(beer);
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")  String id) {
        beerRepository.deleteById(id);
    }
}
