# papperlapappHTMX

A simple counter in HTMX and Spring Boot/Thymeleaf. May or may not be presented in a future episode of Papperlapapp.

Build it with `./gradlew build`, run it with `./gradlew bootRun`.
Enjoy it at `http://localhost:8080`

If I have some time left
- Add deployment
- Add nicer styles and fonts
- Maybe enhance element swapping (for now the whole list is swapped)
  - Manual react so to say

## Notes

- DX is horrible
  - Restart application on every change. Yes this seems to solvable. But why do I need to solve it?
  - Turnaround is no fun
  - Getting started thus feels slow to me
  - PRETTIER
- Getting started for this combination is less than optimal
  - Missing docs
  - Missing getting started
  - There are some helper projects. I cannot say if they help me. :shrug:
- How do you test this?
  - Fire up Spring Boot and some Docker stuff for a single function?
- SASS Support
  - How do I achieve this (easily)?
- I miss components
  - As a way to structure my ui code
  - Fragments are nice but just don't cut it.
- How do I go about with assets like fonts?
  - Simple one, I just don't know it.
  - In JS Land everything already comes along with nice fonts.
- Warnings in thymeleaf regarding HTMX templates.
  - I thought/hoped that this would be adressed by the plugin used. What do I miss here?
- I think HTMX does the job kinda, my criticism is mostly targeted towards the Spring-Boot integration.
  - There are many pieces missing that are a staple in the JS Ecosystem
  - If you are integrating HTMX with sth different, many of the above points could be solved
    - Phoenix/Rails etc.
- That being said: I could get sth done in a surprising short amount of time.
  - Given I start with Spring Boot from - not zero -
- Current verdict:
  - This might be sth if
    - You just want to build sth with very little client side logic.
    - With very little styling requirements
    - If you really despise JS. 
      - If your main goal is server side rendering, then Next or Remix seem to be the more capable option
      - But if you are into the Anti-JS-Movement: Go for it!
    - If your team has no JS ambitions/knowledge