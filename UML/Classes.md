# Classes:
	
## - game (main class)

	
## - gameObject (abstract class) 
### - Character (Interface) // we don't need any object of character
  : Appearance 
  : jump rate
		
### -  mainPlayer (implements Character)
  : Weapon unlocked
	
  
### - Obstacle (abstract class) // we don't need any object of obstacle
  : Coordinate (obj)
#### - abstract Chest
   : reward()
	 - Coin Chest
			: Add coin()
	 - Weapon Chest
			: Add Weapon()

#### - abstract Orcs (villan) {implements Character}
   - Boss (more powerful one)
	 - green
	 - red

####		- Island
				: count {122 locations}
				: length {maybe}

##	- User
		: gameState
		: Username
		: highScore / Coins collected

##	- Game state
		: User (obj)
		: mainPlayer (obj)
		: Terrain (obj)
		
##	- Coordinates
		: float x,y coordinates

##	- Terrain
		// arrangement of different game object
		
##	- Menu
		: load previous game()
		: new game()
		: Pause()
		: Settings
		
