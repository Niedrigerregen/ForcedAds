//same as in kotlin, i don't really know what i'm doing here, it's a composition of many tutorials that indirectly explained this here
//apparantly what i am doing here is just a "heartbeat checker"... man i thought i invented something cool

let url = URL(string: "http://localhost:8000/get_integer")! 

func main() {
    let task = URLSession.shared.dataTask(with: url) { data, response, error in //see how there is URLSession insted of HTTPClient? that's why this code looks so complicated
        
        if let httpResponse = response as? HTTPURLResponse {
            if httpResponse.statusCode == 200 {
                print("Int.True")
                
                DispatchQueue.global().asyncAfter(deadline: .now() + 60) {
                    sendRequest()
                }
            } else {
                print("Int.False")
                exit(0)
            }
        } else {
            print("Int.False")
            exit(0)
        }
    }
    
    task.resume()
}

main()
RunLoop.main.run()