import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.model.GitHubRepositoryResponseModel;
import org.model.NotFoundModel;

import java.util.List;

@Path("/github")
@Produces(MediaType.APPLICATION_JSON)
public class GitHubResource {

    @Inject
    GitHubRepository gitHubRepository;

    @GET
    @Path("/{username}")
    public Response getRepositories(@PathParam("username") String username) {
        try {
            List<GitHubRepositoryResponseModel> responseModels = gitHubRepository.getRepositoriesWithBranches(username);
            return Response.ok(responseModels).build();
        } catch (WebApplicationException e) {
            NotFoundModel notFoundModel = new NotFoundModel(Response.Status.NOT_FOUND.getStatusCode(), e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(notFoundModel).build();
        }
    }
}