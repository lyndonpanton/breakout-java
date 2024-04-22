# TODO

## Todo

## Game design

- [ ] Difficulty should increase once a stage has been cleared
  - More bricks, with the closest layer now closest to the player than the
  previous
  - Ball increases in speed
  - Ball shoots of bricks at a random angle, instead of the opposite angle it
  hit a particular brick 

## Game programming


- [ ] Ball should change trajectory appropriately after a collision with a
brick
    - If the ball hits the left edge of a brick, it goes right. If the ball hits the bottom edge of a brick it goes
    - down, etc.
- [ ] Player should be able to pause the game

## Graphics

## Project management

- [ ] Create a collision matrix

## Sound

- [ ] Ball <-> paddle sound effect
- [ ] Ball <-> vertical edge sound effect
- [ ] Ball <-> top edge sound effect
- [ ] Ball <-> brick sound effect
  - A unique sound effect can be made for each type of brick
- [ ] Game pause sound effect
- [ ] Gameplay music
- [ ] Pause music

## User interface

- [ ] Create a point system for destroying bricks

## Complete

### Game design

### Game programming

- [x] A ball should be drawn on the screen
  - [x] The ball should start in the center of the x-axis and a certain height
  - [x] The ball should be released a random angle (within a range)
- [x] A paddle should be drawn on the screen
- [x] Player should be able to control the paddle movement
  - [x] Movement should be along the x-axis
- [x] Ball should be able to collide with the paddle
  - [x] Ball should change trajectory appropriately after a collision with the
    player paddle
- [x] Ball should be able to collide with the vertical edges of the screen
  - [x] Ball should change trajectory appropriately after a collision with a
    vertical edge
- [x] Ball should be able to collide with the top edge of the screen
  - [x] Ball should change trajectory appropriately after a collision with the
    top edge
- [x] Ball should be destroyed if it goes past the bottom of the screen
- [x] Game should restart with new ball after the previous ball is destroyed
- [x] Rows of bricks should be drawn on the screen
  - [x] Ball should be able to collide with bricks
    - [x] Bricks are destroyed when the ball collides with them

### Graphics

### Project management

### Sound

### User interface
