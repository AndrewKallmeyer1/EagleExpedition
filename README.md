My Object Oriented Design Final Project. 

Written in Java, runs a Boston College themed Oregon Trail style game. 

Makes use of important design elements such as stuctural, behavioral, and creational patterns.

Andrew Kallmeyer
Professor Bolotin
Object-Oriented Design
17 December 2023
Eagle Expedition
	Throughout the course of this class, when thinking about an idea for my final project, I oftentimes tried to imagine myself in a scenario where object-oriented design concepts would carry the most utility. Of course, the purpose of these design elements is to be able to create concise, efficient code that limits the hindrance of thousands of variables and lines of code. When thinking of programs that would present a lot of moving parts for a programmer, I thought of old-school video games. Their constant state progressions, health meters, and inventory items had to be a challenge for any engineer coding in an object-oriented language. The first game that came to mind was Oregon Trail, the desktop game born out of the 1970s and eventually developed into gaming console software, which to me epitomized the template for old-school games, and allowed a lot of room for creative influence. All this being said, I eventually came to the conclusion that I would build a Boston College version of Oregon Trail. 







Basic Game Element Demonstration

List of classes and other files

File entitled “Driver.java” refers to main class, will be used to compile and run rode.
Files including “State” or “Journey” (GameState.java, Journey.java, BeginState.java, TravelingState.java, LandmarkState.java, EndState.java) refer to classes implementing State pattern. 
Files describing activity statements (BuySupplies.java, CheckHealth.java, CheckSupplies.java, ContinueOnTrail.java, GetAdvice.java, TakeRest.java, ViewMap.java) as well as Command.java and Invoker.java refer to classes implementing Command pattern. 
Files Entity.java, EntityMaker.java, MainChar.java, MainCharMaker.java, FamilyMember.java, and FamilyMemberMaker.java refer to classes implementing Factory Method pattern. 
Files including “Market” (EasyMarket.Java, MediumMarket.java, HardMarket.java, MarketTemplate.java) refer to classes implementing Template pattern. 
Files including “Mode” (GameMode.java, EasyMode.java, MediumMode.java, HardMode.java) refer to classes implementing Facade Pattern. 
Files ending in “.txt” refer to text files containing ASCII art used to portray various elements of the game. 

Beginning Game 

Enter “javac Driver.java” and then “java Driver” and the program should begin to run. 
Title ASCII art will appear, prompting user to input “s” to begin. It will prompt you again if you input anything other than “s” or “S”. 

Program will prompt user for names for the group leader (user name) and then names of 4 other people. These are required fields, and program will not let you pass unless you enter all Strings. 
Program will then prompt user to pick a difficulty, or get more information. Game modes differ only on amount of money allotted to the user at the start of the game (this is what More Information will tell you). 

Market
Program will then take user to the supplies market, which will prompt user for inputs on how many units of each supply type (Food, Spare Parts, Apparel, Ammunition, and Oxen) they would like to purchase. 

After purchases, program will tell user final balance and then user will embark on the journey immediately. 

State Progression: Traveling States
At all states, users will be prompted to input “y” if they want to explore their options. If input is not “y”, program will go to the next state. 
Upon pressing “y”, for Traveling States users will be prompted with the 4 options listed above. If input is not one of the listed integers, program will prompt again. 





Upon pressing “2”, program will output the current state of each supply type, as well as the money balance. The supply types deplete at a rate of 30% until reaching 3, when they will deplete by 1. Once a supply type reaches 0, the user dies and the game ends. 






Upon pressing “3”, program will prompt user to input how many days they would like to rest, although they cannot rest more than 1 week and cannot rest more than once in a given state. Resting increases all users’ health at twice the amount of days. 









Upon pressing “4”, program will output the current health of each entity. 
And, when user eventually presses “1”, next state will be presented. 
State Progression - Landmark States

All landmark states are accompanied with ASCII art corresponding to their location. 
Landmark states contain same functionality as traveling states with added options.



Upon pressing “4”, user can view a map, which changes every landmark state with the arrow pointing at the current location. 











Upon pressing “5”, user can buy more supplies. Same as the market, user can only buy as much product as they have money. However, at the landmark outposts, you are able to increase your health by buying food. (10% of pounds of food bought). 
Upon pressing “7”, user can get an advice message on how to complete the game. 

End
If user is able to perform the correct steps to not let their health reach 0 before reaching the end, this success state will be presented. 



Rationale for Chosen Design Patterns
State: This was my first choice of design pattern to use, because I knew it would provide me with the most time and storage saving code. Depending on what state the user is in, different code needs to be output, different options need to be presented, and different functions need to be available to the user. The state pattern allowed me to trim the 10 states I had to only 4, and the ability to outsource them to different files as to not crowd my Driver code. 
Command: Another easy choice for me, command was necessary if I was going to give the user so many options at each state in the game. Command allowed me to organize the code needed to perform all possible command options into their own respective files, as well as interact them with the MainChar.java file which proved useful for getting and setting different aspect quantities and qualities. 
Factory Method: Another distinction I needed to make was that between the main character (the user) and the family or friend group members. Most functions they each contained were common, but some needed to be differentiated, for example the deplete Health function, which imparts more severe health depletion on family members than the main user (as is true in the real game as well). Classifying all the family members as Entity object also allowed me to perform different functions on them as a group in an array or list than separately. 
Template: Template was important because the first real feature of the game is the market, and depending on the game mode the user chose, the market had to present different options for the user based on their budget. Template proved to alleviate a mess of if-else statements, and simple organize different program outputs into files based on difficulty. Using the MarketRunThrough function in the Driver class also made it much easier to run an instance of a market template with one line in the main function in Driver. 
Facade: One of the integral aspects of the game is also the difficulty level, and as the program explains the only distinction between game modes is the amount of money allotted to the player. Therefore, the facade pattern worked closely with the template pattern to discern the amount of money the user would get based off their game mode input. 


