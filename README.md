# ForcedAds

ForcedAds has a pretty boring but also selfexplanatory name as i'm not very talented in naming stuff. It was created to detect the bypass of turning off Wi-fi 

## Why did i create this?

I vaguely remember a mobile single player game that i played a long time ago which had VERY MANY Ads. I'm talking about 1 double-Ad per minute so logically i turned off my WiFi and the game froze and told me to connect to the internet again.
I was interested in how the developers implmented this feature in their code so i made a concept of how such a feature would look like in code.

## The Concept
The Application will send a request to the server and if no respond comes in under 60 seconds, the game shuts down. Pretty simple

## Bad sides
A bypass by manipulating the source code would be fairly easy and i'm not planning to make it more safe. Just make your game closed source lol

## Proof of Concept

For the Proof of Concept i decided to code it in python because i think it's the most simple as it's often used for backend stuff so the code also turned out as pretty short with just 14 lines

```
import sys
import requests
import time

Url = "http://localhost:8000/get_integer"

while True:
    if requests.get(Url).status_code == 200:
        print("Int.True")
        time.sleep(60)
    else:
        print("Int.False")
        sys.exit()

    time.sleep(60)

```
