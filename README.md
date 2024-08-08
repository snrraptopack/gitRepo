Sure, here's a detailed documentation for your code using Markdown:

# GitHub Repository Explorer

This project provides a REST API to fetch repository and branch information from GitHub for a given user.

## Project Structure

The project is organized into the following packages:

1. `org.model`
   - `RepositoryModel`: Represents a GitHub repository.
   - `BranchModel`: Represents a branch of a GitHub repository.
   - `CommitModel`: Represents a commit associated with a branch.
   - `GitHubRepositoryResponseModel`: Represents the overall response model for a user's repositories.
   - `NotFoundModel`: Represents an error response when a user is not found.
2. `GitHubResource`: The REST resource class that handles the incoming requests.
3. `GitHubRepository`: The service class that interacts with the GitHub API to fetch repository and branch information.
4. `GitHubRepoProxy`: The REST client interface that communicates with the GitHub API.

## Running the Application

To run the application, you can use the following command:

```
./gradlew quarkusDev
```

This will start the application in development mode, allowing you to make changes to the code and see the changes reflected in the running application.

## Endpoints

The application exposes the following endpoint:

### `GET /github/{username}`

This endpoint retrieves the repository and branch information for the specified GitHub user.

**Input**:
- `username`: The GitHub username.

**Output**:
- If the user is found, the response will be a list of `GitHubRepositoryResponseModel` objects, each containing the repository name, username, and a list of `BranchModel` objects with the branch name and commit SHA.
- If the user is not found, the response will be a `NotFoundModel` object with the status code and error message.

## Class Descriptions

### `RepositoryModel`
- Represents a GitHub repository.
- Contains the following fields: `name`, `fork`, and `branches_url`.

### `BranchModel`
- Represents a branch of a GitHub repository.
- Contains the following fields: `name`, `commit`, and `sha`.
- Provides two constructors: one with `name` and `commit`, and another with `name` and `sha`.

### `CommitModel`
- Represents a commit associated with a branch.
- Contains the following fields: `sha` and `url`.

### `GitHubRepositoryResponseModel`
- Represents the overall response model for a user's repositories.
- Contains the following fields: `repositoryName`, `username`, `branches`, and `notFoundModel`.
- Provides two constructors: one with `username`, `repositoryName`, and `branches`, and another with `notFoundModel`.

### `GitHubResource`
- The REST resource class that handles the incoming requests.
- Provides a single endpoint: `GET /github/{username}`.
- Calls the `GitHubRepository` service to retrieve the repositories and branches for the specified user.
- If a `NotFoundModel` is found in the response, it returns a 404 Not Found response with the `NotFoundModel` as the entity.
- Otherwise, it returns a 200 OK response with the list of `GitHubRepositoryResponseModel` objects.

### `GitHubRepository`
- The service class that interacts with the GitHub API to fetch repository and branch information.
- Provides a single method: `getRepositoriesWithBranches(String username)`.
- Calls the `GitHubRepoProxy` to retrieve the user's repositories and branches.
- If the list of repositories is empty, it creates a `NotFoundModel` and returns a `GitHubRepositoryResponseModel` with the `notFoundModel` field set.
- Otherwise, it creates a list of `GitHubRepositoryResponseModel` objects, each containing the repository name, username, and a list of `BranchModel` objects with the branch name and commit SHA.

### `GitHubRepoProxy`
- The REST client interface that communicates with the GitHub API.
- Provides two methods: `getRepositories(String username)` and `getBranches(String owner, String repo)`.
- These methods throw a `WebApplicationException` when the requested user or repository is not found.

## Overloading

There is no overloading in the provided code. The constructors for `BranchModel` and `GitHubRepositoryResponseModel` are not overloaded, but provide different constructors to handle different use cases.
