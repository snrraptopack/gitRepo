import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.model.BranchModel;
import org.model.NotFoundModel;
import org.model.RepositoryModel;

import java.util.ArrayList;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://api.github.com")
public interface GitHubRepoProxy {

    @GET
    @Path("/users/{username}/repos")
    List<RepositoryModel> getRepositories(@PathParam("username") String username) throws WebApplicationException;

    @GET
    @Path("/repos/{owner}/{repoName}/branches")
    ArrayList<BranchModel> getBranches(@PathParam("owner") String owner, @PathParam("repoName") String repo) throws WebApplicationException;
}