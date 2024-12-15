 //-----------------(it creates fake data)--------------------------

// const { faker } = require('@faker-js/faker');

// let createRandomUser = () => {
//     return {
//       userId: faker.string.uuid(),
//       username: faker.internet.userName(),
//       email: faker.internet.email(),
//       password: faker.internet.password(),
//     };
//   }
//   console.log(createRandomUser());


//-------------------------------------------//Second method to connect with sql//-------------------------------------------

const mysql = require('mysql2');

const connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    database: "develop_app",
    password: "jarvisdata3000@private",
  });

// let sq = "SHOW TABLES";
// try{
//   connection.query(sq , (err, result) => {
//     if(err) throw err;
//     console.log(result);
//     console.log(result.length);
//     console.log(result[0]);
//     console.log(result[1]);
//   });
// }
// catch(err) {
//     console.log(err);
// }

// connection.end();

//-------------------------------------------
//-------------------------------------------

     //Inserting first New Data

// let q = "INSERT INTO user (id, username, email, password) VALUES (?, ?, ?, ?)";
// let user = ["123","123_newuser","abc@gmail.com","abc"];

// try{
//   connection.query(q , user , (err, result) => {
//     if(err) throw err;
//     console.log(result);
//   });
// }
// catch(err) {
//     console.log(err);
// }

// connection.end();
//-------------------------------------------
//-------------------------------------------

     //Inserting 2 or more New Data
     
// let q = "INSERT INTO user (id, username, email, password) VALUES ?";
// let users = [["123b","123_newuserb","abc@gmail.comb","abcb"],
//              ["123c","123_newuserc","abc@gmail.comc","abcc"]];

// try{
//   connection.query(q , [users] , (err, result) => {
//     if(err) throw err;
//     console.log(result);
//   });
// }
// catch(err) {
//     console.log(err);
// }

// connection.end();

//-------------------------------------------
//------------------(Insert data in Bulk using faker)-------------------------

// const { faker } = require('@faker-js/faker');

// let getRandomUser = () => {
//     return [
//       faker.string.uuid(),
//       faker.internet.userName(),
//       faker.internet.email(),
//       faker.internet.password(),
//     ];
//   };


// let data = [ ];
// let q = "INSERT INTO user (id, username, email, password) VALUES ?";

  // for(let i=1; i<=10; i++){
  //   data.push(getRandomUser());          
  //   }

// try{
//   connection.query(q , [data] , (err, result) => {
//     if(err) throw err;
//     console.log(result);
//   });
// }
// catch(err) {
//     console.log(err);
// }

// connection.end();

//-------------------------------------------
//--------------------------(Insert data in Bulk using array)-----------------

// let data = [ ];
// let q = "INSERT INTO user (id, username, email, password) VALUES ?";

//   for(let i=111; i<=211; i++){   
//          data.push([`g${i}`,`gagan123_newuser${i}`,`gagan${i}abc@gmail.com`,`gaganabc${i}`]);

//     }

// try{
//   connection.query(q , [data] , (err, result) => {
//     if(err) throw err;
//     console.log(result);
//   });
// }
// catch(err) {
//     console.log(err);
// }

// connection.end();

//----------------------------------------------------------------------------------------------------------------------------
const express = require("express");
const app = express();
const path = require("path");
const { cachedDataVersionTag } = require('v8');
//----------------------------------------------------------------------------------------------------------------------------
app.set("view engine","ejs");
app.set("views",path.join(__dirname,"/views"));
//----------------------------------------------------------------------------------------------------------------------------
const methodOverride = require("method-override"); 
app.use(methodOverride('_method'));
//----------------------------------------------------------------------------------------------------------------------------
app.use(express.urlencoded({extended:true}));
//----------------------------------------------------------------------------------------------------------------------------
const { v4: uuidv4 } = require('uuid');  //to add new user in database
//----------------------------------------------------------------------------------------------------------------------------

port = 8080;
app.listen( port , (req,res) => {
  console.log("server is listening to port 8080");
})

//-----------(show total number of users)-----------------------------------------------------------------------------------------------------------------

app.get( "/" , (req,res) => {
  
let q =`SELECT count(*) FROM user;`
try{
  connection.query( q , (err, result) => {
    if(err) throw err;
    console.log(result[0][`count(*)`]);
    let count=result[0][`count(*)`];
    res.render("home.ejs",{count});
  });
}
catch(err) {
    console.log(err);
    res.send("Some error in  database");
}


});

//-----------(show userid,username and email of all the users)-----------------------------------------------------------------------------------------------------------------

app.get("/user", (req,res) => {
  let q = `SELECT * FROM user `;

  try{
  connection.query( q , (err,result) => {
    if(err) throw err;
    res.render("showusers.ejs",{result});
  });
}
catch(err){
  console.log(err);
  res.send("some error in db");
}


});

//-----------(edit Route)-----------------------------------------------------------------------------------------------------------------

app.get("/user/:id/edit", (req,res) => {
  let { id } = req.params;

  let q = `SELECT * FROM user WHERE id="${id}";`;
  try{
    connection.query( q , (err,result) => {
      if(err) throw err;
      let user = result[0];
      res.render("edit.ejs",{user});
    })
  }
  catch(err){
    console.log(err);
    res.send("some error in database");
  }
 
});

//-----------(Update (DB EDIT) Route)-----------------------------------------------------------------------------------------------------------------


app.patch("/user/:id/edit", (req,res) => {
  let { id } = req.params;

  let q = `SELECT * FROM user WHERE id="${id}"`;
  try{
    connection.query( q , (err,result) => {
      if(err) throw err;
      let user = result[0];
      if(user.password==req.body.password) {

        let newname = req.body.username;

        let q = `UPDATE user SET username="${newname}" WHERE id="${id}"`;
        try{
          connection.query( q , (err,result) => {
            console.log("name updated")
            res.redirect("/user");
          })
        }
        catch(err){
        console.log(err);
        res.send("some error in database");
        }
  
      }
      else{
        res.send("incorrect password");
      }
    })
  }
  catch(err){
    console.log(err);
    res.send("some error in database");
  }
 
});

//-----------(New user Route)-----------------------------------------------------------------------------------------------------------------

app.get("/user/new", (req,res) => {
  res.render("new.ejs");
})

//-----------(New user DB Route)-----------------------------------------------------------------------------------------------------------------

app.post("/user/new", (req,res) => {
  let  {username,email,password} = req.body ;
  let id=uuidv4();
  let q = `INSERT INTO  user ( id, username, email, password) VALUES ("${id}","${username}","${email}","${password}");` ;

  try{
    connection.query( q, (err,result) =>  {
      if(err) throw err;
      res.redirect("/user");
  });
}
catch(err){
  console.log(err);
  res.send("some error in database");
}
 })


//-----------(DELETE Route)-----------------------------------------------------------------------------------------------------------------

app.get("/user/:id/delete",  (req,res) => {
  let {id} = req.params;

  q = ` SELECT * FROM user WHERE id="${id}"; ` ;
  try{
  connection.query( q, (err,result) => {
    if(err) throw err;
    let user = result[0];
    res.render("delete.ejs",{user});  
  })
  }
  catch(err){
    console.log(err);
    res.send("some error in databse");
  }
})

//-----------(Delete (DB) Route)-----------------------------------------------------------------------------------------------------------------

app.delete("/user/:id" , (req,res) => {
  let { id } = req.params;
  let remail = req.body.email;
  let rpassword = req.body.password;

  q = ` SELECT * FROM user WHERE id="${id}"; ` ;

  try{
  connection.query( q, (err,result) => {
    if(err) throw err;
    let user = result[0];
    if(user.email == remail && user.password == rpassword) {

         q = `DELETE FROM user WHERE id="${user.id}"; ` ;
         try{
         connection.query( q, (err,result) => {
           if(err) throw err;
           res.redirect("/user");
         })
         }
         catch(err){
           console.log(err);
           res.send("some error in databse");
         }
    } 
    else {
      res.send("you entered incorrect properties");
    }
     
  })
  }
  catch(err){
    console.log(err);
    res.send("some error in databse");
  }
})







































