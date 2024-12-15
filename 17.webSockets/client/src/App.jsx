import './App.css';
import { io} from "socket.io-client";
import{ useEffect, useState, useMemo} from "react";
import { Typography, Button, Container, Box} from "@mui/material";

export default function App(){

  const [ UserRoomId, setUserRoomId] = useState("");

  const [ message, setMessage] = useState("");
  const [ roomName, setRoomName] = useState("");
  const [ roomId , setRoomId ] = useState("");
  const [ messageArray , setMessageArray] = useState([]);

  // socket=>particular, on=>listener(receiveer)
  const socket = io("http://localhost:4000");

  useEffect(()=>{
    socket.on("connect", ()=>{
      console.log(`User ${socket.id} connected in client side`);
      setUserRoomId( socket.id);
    })

    socket.on("receive-message", ( msg)=>{
      console.log(msg);
      setMessageArray(( old)=>{ return [...old, msg ]});
    })

    // socket.on("sendToAll",(msg)=>{
    //   setMessageArray(( old)=>{ return [...old, msg ]});
    // })

  },[ ]);

  const handleSubmitRoomIdMessage = ( e) =>{
    e.preventDefault();
    socket.emit( "message" , { message, roomId});
  }

  const handleSubmitRoomNameToJoin = ( e)=>{
    e.preventDefault();
    socket.emit( "join-room", roomName);
    setRoomName("");
  }

    return(
      <div >
        <h1>Send Message</h1>
        <p>this is room id: { UserRoomId}</p>
        <Container>
            <form>
            <input type="text" placeholder="Enter Room Name" value={ roomName} onChange={( e)=>{ setRoomName(e.target.value);}} />
            <Button variant="contained" color="secondary"  onClick={ handleSubmitRoomNameToJoin}>Join Room</Button>
            </form>
            <form>
              <input type="text" placeholder='Enter Room Id' value={ roomId} onChange={( e)=>{ setRoomId(e.target.value)}} />
              <input type="text" placeholder="Enter Message" value={ message} onChange={( e)=>{ setMessage(e.target.value)}} />
              <Button variant="contained" color="success" onClick={handleSubmitRoomIdMessage} >Send</Button>
            </form>
            <Box>
              { 
               messageArray.map(( message, idx )=>{
                  return <p key={idx}> {message} </p>
                })
              }
            </Box>
        </Container>
      </div>
    )
}























/*(1). basics of websockets */

/*
import './App.css';
import { io} from "socket.io-client";

export default function App(){


  // socket=>particular, on=>listener(receiveer)
  const socket = io("http://localhost:3000");

  useEffect(()=>{

    //1.
    socket.on("connect", ()=>{
      console.log("User connected in client side");
      console.log("id",socket.id);
    })

    //2.
    socket.on("welcome", ( mess)=>{
      console.log(mess);
    } );

    //3.
    socket.on("welcomeBroadcast", ( msg)=>{
      console.log(msg);
    })

    //4.
    socket.emit("client msg", `I AM CLIENT`);

    //5.
    socket.on("disconnect",()=>{
      console.log(`disconnect ho gya bhai`);
    })

    //refresh when the page reload and disconnect done,[ its react feature before useEffect run the cleanup function calls]
    return () => {
      //means firstly , disconnect is called
      socket.disconnect();
    }

  },[]);



    return(
      <div >
        <h1>hello</h1>
      </div>
    )
}

*/