import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.model.BranchModel;

import org.model.GitHubRepositoryResponseModel;
import org.model.NotFoundModel;
import org.model.RepositoryModel;

import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class GitHubRepository {

    @Inject
    @RestClient
    GitHubRepoProxy proxy;

    public List<GitHubRepositoryResponseModel> getRepositoriesWithBranches(String username) {
        List<GitHubRepositoryResponseModel> responseModels = new ArrayList<>();
        List<RepositoryModel> repositories = proxy.getRepositories(username);

        if (repositories.isEmpty()) {
            NotFoundModel notFoundModel = new NotFoundModel(Response.Status.NOT_FOUND.getStatusCode(), "User not found");
            responseModels.add(new GitHubRepositoryResponseModel(notFoundModel));
            return responseModels;
        }

        for (RepositoryModel repo : repositories) {
            if (!repo.fork) {
                try {
                    ArrayList<BranchModel> branches = proxy.getBranches(username, repo.name);
                    List<BranchModel> branchModels = new ArrayList<>();

                    // Correctly extract the sha
                    for (BranchModel branch : branches) {

                        branchModels.add(new BranchModel(branch.name, branch.commit.sha));
                    }
                    responseModels.add(new GitHubRepositoryResponseModel(username, repo.name, branchModels));
                } catch (Exception e) {
                    System.err.println("Error fetching branches for " + repo.name + ": " + e.getMessage());
                }
            }
        }

        return responseModels;
    }
}