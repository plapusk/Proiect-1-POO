# Proiect 1 POO #


__General Structure__

|admin|
  -Command Execute
    -|input| -> input classes
  -Page Handler
    -|movie| -> movie class and Database
    -|user|  -> user class and Database
    -|page|  -> page class and all subpages


__Main functionalities__

* Input and Output *

For input I had to build fitting classes to contain the Json type input. For 
output I used an ArrayNode where I included all the Error type ObjectNodes.

* Movies *

The way we kept the DataBase for all the movies from the Input was through a
singleton class that keeps an ArrayList with all the objects. This class has a
getter and setter for the array, and a newArray function for resesting the
data inside the DataBase. This also implemented a function to search if a
movie by name.

The Movie class has a lot more fields, but doesn't have that many methods. We
have both a constructor from input and a copy constructor. Other 2 methods are
contains and checkCountry which verify if certain elements are in the movie.
The rate function is to update the average rating and getJson is 
self-explanatory.

* Users *

The users are also organized in a singleton DataBase that has the same
functionalities as the first one, but also has a method to add users and also
check if an login input is valid.

The User class has a lot more methods. There are functions to add movies to
watch and purchased list(also to check if movies are in said lists). Add
movies to liked and rated list, plus methods to update the respective fields
inside the MovieClass. There is also a small curency system with functions
like buy or payPremium

* Pages *

This is the main structure of the project. The Page abstract class has 2
methods common to all Subpages. The Onpage which imlpements the specific
features for every page, and the getMovies which gets all the Movies visible
on the page. We also has a method to check if the Page can access another page
(the page is contained in the subPagesField)

NOTE: Factory was not learned before this project was made (will updated in 
second faze)

__Organization of Pages and Users__

//Page handler\\

This class represents the current instance of our program. This has all the
currentPage, currentUser and all the Movies that are on screen at the time.
This class makes the connection between the commands received and the other
components of the project.