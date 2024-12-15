const express = require("express");
const app = express();
const port = 8080;

//---------------------------------------------------------------

app.use(express.urlencoded({ extended:true}));      //express don't understand post data ,so we use middleware.
app.use(express.json());                            // if data is in json form then again we use middleware

//---------------------------------------------------------------

app.listen(port, () => {
    console.log(`listening to port ${port}`);
})

app.get("/register", (req,res) => {
    let {user,password}=req.query;
    res.send(`standard GET response, Welcome ${user}`);
})

app.post("/register",(req,res) => {
    let {user,password} = req.body;
    res.send(`stardard POST response, Welcome ${user}`);
})







