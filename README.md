Technical Breakdown:

The technical breakdown of the app is as follows:

Using the MVP architecture, I built an app that is modularized in to separate components.
There are distinct layers of the app, and each layer has a core focus:

1. App: The UI module
2. Data: The data module, which is for local DB purposes.
3. Api: The api module is to support deserialization of object responses from the server
4. Services: The services module is the middle layer that handles api requests to and from the UI

You will find that in the UI layer each entity is separated by package. This is so that we can maintain
structure of what piece of the UI is being worked on. 
- The framework and injection packages are custom
made to support Dagger 2 for dependency injection. 
- The navigation package serves a utility package
that allows for intenting in and out of activities.
- The services package includes the necessary api calls, preference storage, local DB storage, and handling of
api to and from the Services module into our Mobile layer.
- The UI package then is broken down by what each screen does. This app has a Splash screen, a login screen, and a feed screen. 

This was built specifically this way to achieve modularity, separation of code, testability, and decoupling of moving parts. As you can see from the gradle files, only necessary modules are made aware of each other, as to not expose any dependencies in to any module that aren't needed. 

Flow of the app works as follows:
- Splash screen (3 second load state)
- Login Page -> login with creds
- Feed screen -> User profile page with recent posts of user and ability to like/unlike photos

Libraries Used:
1. Retrofit2
2. OkHttp
3. Realm
4. Gson
5. Picasso
6. Recyclerview/Cardview
7. Dagger 2
8. Picasso transformations
9. Flowing gradient
10. LikeButton
11. Butterknife
12. RxAndroid2/RxJava2

These are the libraries used in this project. The only uncommon libraries used here are the Flowing gradient and LikeButton libraries. These were only used for UI polish purposes (splash screen and like button). This could also be accomplished with ViewAnimators and gradients, however, due to ease of use and the lightweight of these libraries, it was a bit more of a pragmatic solution for me.

I chose to use Retrofit with OkHttp and RxJava2 because this allowed me to do a few things.
1. Retrofit with OkHttps allows me to cache requests, see responses through logging interceptors, and write an api client that was easy to manage.
2. Since the base url for the api calls was the same, Retrofit was a good answer as it takes in a base url.
3. Retrofit is a much faster alternative to using AsyncTasks and easier to manage throughout the lifecycle of the application.
4. Realm is one of the fastest local storage db's being used in Android today. It has a clean api and easy to manage. Realm objects appear as normal POJO's and are easy to query and modify. Realm has a syncronous and asyncronous api, which allows for updating your db in the background.
5. Picasso was used for image loading throughout the app. The Picasso api allows for image caching, error handling, transformations, and easy to understand api. The tradeoff between Picasso and Glide has been noted by many, as Picasso does have more memory leaks than Glide (due to mostly static constructs). Also Glide can deal with Fragment lifecycles better than Picasso can. However, the tradeoff is in their library size. Glide is almost 4 times the size of Picasso. Glide also downloads images and sizes them to fit the container. This can lead to the same image being downloaded multiple times, whereas Picasso saves the image in its organic state.
6. RecyclerView and CardView are material design concepts in Android now. Recyclers are the more efficient choice than ListViews, and I used them to build the feed of recent media. In order to display these items in the adapter, I chose to use Cards, as they give a better UI feel to each media item.
7. Dagger 2 is an infamous DI library. The pros of using one is the modularity and testability it brings as well as making the Activity not as bloated with code. However, it is really hard to debug if something is not working properly. It also has issues with Butterknife injection timing, and is not easy to decipher. Therefore, it is really just a comfort level with this library over time that makes it worth it.
8. Butterknife injection was what I used to bind views in the View of my MVP framework. Butterknife's downside is that in really large projects it sometimes does not erase previous view signatures and can be a hassle to clean after. However, because of the simplicity of this project and the readability of code it was a nice thing to have.