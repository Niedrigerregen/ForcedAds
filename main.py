#An evil program for a game to request an integer from the server and if it doesn't get an answer
#within 60 seconds it will exit the game. If it gets an answer it will try again in 60 seconds. like i said very evil.

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