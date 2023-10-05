
# Photolooker Backend

Welcome to the back-end repository of Photolooker, a cutting-edge platform designed to revolutionize photo management and processing. This repository contains the code for the back-end part of the Photolooker application.

## About Photolooker

Photolooker is a state-of-the-art photo management system engineered to streamline the complexities of image handling. From seamless uploading and intuitive organization to powerful editing tools, Photolooker offers a user-friendly experience tailored for both casual users and photography professionals.

## Getting Started

To get started with the Photolooker back-end, follow these steps:

1. **Clone the Repository:**
   ```
   git clone <repository-url>
   cd photolooker-backend
   ```

2. **Set Up Environment Variables:**

   Create a `.env` file in the root directory of the backend project with the following content:

   ```
   SPRING_REDIS_HOST=
   SPRING_REDIS_PORT=
   SPRING_REDIS_PASSWORD=
   SIRV_CLIENT_ID=<Your Sirv Client ID>
   SIRV_CLIENT_SECRET=<Your Sirv Client Secret>
   ```

   Replace `<Your Sirv Client ID>` and `<Your Sirv Client Secret>` with the appropriate values.

3. **Build and Run the Application:**
   ```
   ./gradlew build
   java -jar build/libs/photolooker-backend.jar
   ```

   The backend API will be accessible at `http://localhost:8080`.

## API Documentation

Explore the Photolooker API endpoints and their functionalities by referring to the API documentation. Detailed information about request and response formats can be found there.

## Contributing

We welcome contributions from the community. If you find any issues or have ideas for improvements, please feel free to open an issue or create a pull request.

## Future Updates

Photolooker is continuously evolving. Stay tuned for updates and enhancements. An upcoming article will provide an in-depth overview of the project and its features.

Thank you for being a part of Photolooker!

---

Feel free to modify this README to fit your project's specific details and requirements. If you need any further assistance or have additional information you'd like to include, please let me know!