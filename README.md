# CodingChallengeGB

A) nRead through the challenge and piped out my layers first and created the shell of my classes to navigate building.
(So I created NetworkService, Repository, Fragment, ViewModel, RecyclerAdapter classes First)

B) Fetched the url on Postman to see what kind of data shows up when fetched. Created the Guide Model first. (Later realized the JSON data was a whole object so had to create
  Guides object that holds the list).
  
C) Then Started by creating Resource file. Moved to NetworkService/GuideApi for Retrofit and worked my way down the layers from Repo to View

D) Realized we'll need to use Glide for image loading on the recycler view so added that upon working on the viewholder.

E) Ran into issues with my Kotlin version that I never figured out!!! Didn't get to utilize kotlin extension functions like apply and let to deal with NULL checks. Also had to
  use "object != null" instead of elvis operators or isNotEmpty functions. Wanted to use let and apply in the recycleradapter and in the fragment.
  
F) Got the app working and displaying what I needed to

G) Updated gradle and create build flavors A and B to run as debug and set title in activity to BuildConfig.Flavor4

I) Ran out of time when trying to do Unit Testing!!!

***Took about 2 hours and 20 minutes when I started to try unit testing***

J) I was going to start unit testing at the network service layer and stub out the api call with mockwebserver lib

K) Then stub out NetworkService reponse and write successful and then failure unit test for Repository and the same for Viewmodel

L) Then write Espresso tests for the view. Something along the lines of loading the view checking the data for the first recycler item and validating that, scroll the list
and then check the last recycler item for accurate data and that the icon is displaying
