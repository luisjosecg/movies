## Movies App

## Description

Movies App is a modular Android application developed using **Jetpack Compose**, **Hilt** for dependency injection, and **Retrofit** for API communication. The application follows the **Clean Architecture** principle, ensuring a clear separation of responsibilities and facilitating maintenance and scalability.

## Project Architecture

The application is structured following **Clean Architecture** principles, with a clear separation of layers:

### 🗂️ Folder Structure


### 🌟 Architecture Layers
1. **Presentation (UI)**
   - Implements user interface using Jetpack Compose
   - Uses ViewModel and State management
   - Reusable composables and screens

2. **Domain**
   - Contains business logic
   - Defines entities and use cases
   - Repository interfaces
   - Independent of Android framework

3. **Data**
   - Repository implementations
   - Data sources (API)
   - Data mapping (DTOs)


## Technologies Used

- **Kotlin:** Primary programming language.
- **Jetpack Compose:** For UI development.
- **Hilt:** For dependency injection.
- **Retrofit:** For API consumption.
- **OkHttp:** For HTTP request handling.
- **Navigation Compose:** For screen navigation.


## Project Setup

### 1. Clone the Repository
https://github.com/luisjosecg/movies.git


### 2. API Key Configuration
Create a `local.properties` file in the project root:
- API_KEY=your_api_key_here
- Authorization=your_authorization_here


### 3. Build and Run



## Module Structure

### Main Module (app)
- Contains global project configuration and application startup.
- Initializes navigation and global theme.

### Movie List Feature Module (featuremovielist)
- Displays a list of movies.
- Fetches the list from the API and displays it using Jetpack Compose.

### Movie Detail Feature Module (featuremoviedetail)
- Displays details of a selected movie.
- Shows detailed information of the chosen movie.

---
