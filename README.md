# Kotlin REST API -with Swagger2

This is a Kotlin REST API project that demonstrates the usage of a `NetworkDataSource` class for interacting with a remote bank API over the network. The `NetworkDataSource` uses RESTful calls to perform CRUD operations on bank data.

## Overview

The `NetworkDataSource` class is an implementation of the `BankDataSource` interface. It leverages the `RestTemplate` class from Spring Framework to make HTTP requests and retrieve data from the remote bank API.

The class provides the following functionality:

- `getBanks()`: Retrieves a collection of Bank objects from the remote bank API.
- `retrieveBank(accountNum: String)`: Retrieves a Bank object from the remote bank API based on the account number.
- `createBank(bank: Bank)`: Creates a new Bank object in the remote bank API.
- `updateBank(bank: Bank)`: Updates an existing Bank object in the remote bank API.
- `deleteBank(accountNum: String)`: Deletes a Bank object from the remote bank API based on the account number.

## Configuration

The `NetworkDataSource` class is annotated with `@Repository("network")`, indicating that it is a Spring repository bean and can be injected into other components.

The class has two dependencies injected via constructor:

- `restTemplate`: An instance of `RestTemplate` used for making HTTP requests.
- `bankApiUrl`: A configuration property that specifies the URL of the remote bank API. It can be configured externally using a properties file or environment variables.

## Usage

To use the `NetworkDataSource` in your project, follow these steps:

1. Make sure you have the necessary dependencies in your project, including the Spring Framework and `RestTemplate`.

2. Configure the `bankApiUrl` property to point to your desired remote bank API URL.

3. Instantiate an instance of `NetworkDataSource` and use its methods to interact with the remote bank API.

For example, you can use the `getBanks()` method to retrieve a collection of Bank objects from the remote bank API:

```kotlin
val networkDataSource = NetworkDataSource(restTemplate, bankApiUrl)
val banks = networkDataSource.getBanks()
// Process the retrieved banks as needed
```
## Contributions
Contributions to this project are welcome! If you find any issues or want to add new features, feel free to open a pull request or submit an issue.

## License
This project is licensed under the MIT License.

###  Kotlin REST API - Swagger-UI

![Project Logo](https://i.postimg.cc/7hWR6Qjj/Screenshot-from-2023-07-13-13-44-02.png)