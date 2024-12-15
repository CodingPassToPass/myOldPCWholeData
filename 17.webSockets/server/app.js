import cors from "cors";
import express from "express";
const app = express();
import { Server} from "socket.io";

import http from "http";

// app.use(cors());


const server = http.createServer(app);

const io = new Server(server, {
    cors:{
        origin:"http://localhost:5173",
        methods:['GET','POST'],
        credentials:true,
    }
});

app.get( "/", ( req,res)=>{
    res.send("hello ji");
})
   
//to maintain room persistance 
let prooms; 



io.on("connection", ( socket)=>{

    //1. take input from form and send to all
    // socket.on("message", (msg)=>{
    //     console.log(msg);
    
    //     io.emit("sendToAll", msg)                       //send to all
    //     socket.broadcast.emit( "sendToAll", msg)     //we can use this also to send message to all
    // });
    

    // 2. take input from form and send to id person
    socket.on("message", (msg)=>{
        console.log(msg);
            // io.to( msg.roomId).emit("receive-message", msg.message);
        socket.to( msg.roomId).emit("receive-message", msg.message);
    });

    //3. take input and join the room
    socket.on("join-room",( roomName)=>{
        socket.join( roomName);
        console.log(`User joined the room ${roomName}`);
        console.log(socket.id, getRoomsByUser(socket.id));
    })

    function getRoomsByUser(id){
        let userRooms = [];
        let rooms = io.sockets.adapter.rooms;

        for(let room in rooms){
            if(rooms.hasOwnProperty(room)){
                let sockets = rooms[room].sockets;
                if(id in sockets){
                    userRooms.push(room);
                }
            }
        }
        return userRooms;
    }

});





const PORT = 3000;
server.listen( PORT, ( req, res)=>{
    console.log(`hello ji kaisa ho, ${PORT}`);
})













/*(1). this is  first part for basics---------------------*/
/*

// io=>entire, on=>listener(receiver)
io.on("connection", ( socket)=>{
    console.log("User Connected in server");
    console.log("Id", socket.id);

    //1.
    socket.on("client msg",(msg)=>{ 
        console.log(msg," ",socket.id)
    });

    //2.
    socket.emit("welcome",`Welcome, you are ${socket.id} (from server)`);
   
    //3.
    socket.broadcast.emit("welcomeBroadcast",`this broadcast is conducted by ${socket.id}`);
    
    //4.
    socket.on( "disconnect", ()=>{
        console.log("User Disconnected , ID : ", socket.id);
    })

});

*/