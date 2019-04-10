# Babylon-Light by Rafal Ozog

A programming challenge given by Babylon Health

1. The app architecture is based on the MVVM Design Pattern. Each screen consists of Activity or Fragment and its relevant ViewModel, being responsible for providing data.

2. The central part of data flow is Data Repository that has 2 main tasks. First is to fetch data from the Back-End (it's performed using separate ApiService), to cache it, and make accessible for particular viewmodels. Data Repository has been implemented using Singleton design pattern.

3. Caching mechanism allows to use the application after the Internet connection is interrupted.

4. ApiService consists of ApiClient (which is the final gate of this Front-End application) and ApiUtils class (being its interface). This part uses Retrofit2 library to perform communication with server.

5. Flow of data given by server is operated by RxJava (Reactive Java) observables, that allows to manage data streams given by few separate end-points simultaneously, and its potential error states.

6. GSON library is used for de-serializing data flowing from the Back-End.

7. Unit Testing part consists of Local Unit Tests (performed for data models, like Post, User and Comment), and Instrumentation Unit Test (performed for Data Repository Caching mechanism). 

8. Alpha Testing has been separated from coding phase, and performed by developer on physical device.