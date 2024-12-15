const mongoose = require("mongoose");
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
main()
  .then( () => {
    console.log("connection successful");
  })
  .catch((err) => {
    console.log(err);
  })

async function main() {
    await mongoose.connect("mongodb://127.0.0.1:27017/test");
}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
const userSchema  = new mongoose.Schema({
    name: String,
    email: String,
    age: Number,
})
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
const User = mongoose.model("User", userSchema);            // const Employee = mongoose.model("Employee", userSchema);

/*--------------------------(Insert and InsertMany )---------------------------------------------------------------------------------------------------------------------------------------------*/
// const user1 = new User({
//     name: "Adam",
//     email: "adam@yahoo.in",
//     age: 48,
// });

// user1.save();
//-------------------------
// const user2 = new User({
//     name: "Eve",
//     email: "eve@yahoo.in",
//     age: 50,
// });

// user2
//     .save()
//     .then((res) => {
//         console.log(res);
//     })
//     .catch((err) => {
//         console.log(err);
//     })
//-------------------------
// User.insertMany([
//     {name: "Tony",email: "tony@gmail.com",age: 50},
//     {name: "Peter",email: "peter@gmail.com",age: 30},
//     {name: "Bruce",email: "bruce@gmail.com",age: 47},
// ]).then( res => {
//     console.log(res);
// })

/*--------------------------(find , findOne and findById )---------------------------------------------------------------------------------------------------------------------------------------------*/

// User.find({})
//     .then((result) => {
//         console.log(result);
//     })
//     .catch(err => {
//         console.log(err);
//     })
//-------------------------
// User.find({age: {$gt: 47}})
//     .then( result => {
//         console.log(result);
//     })
//     .catch( err => {
//         console.log(err);
//     })
//-------------------------
// User.find({age: {$gt: 47}})
//     .then( result => {
//         console.log(result[1]);
//     })
//     .catch( err => {
//         console.log(err);
//     })
//-------------------------
// User.find({age: {$gt: 47}})
//     .then( result => {
//         console.log(result[1].name);
//         console.log(result[1]._id);
//         console.log(result[1].age);
//         console.log(result[0].name);
//     })
//     .catch( err => {
//         console.log(err);
//     })
//-------------------------
// User.find({_id:"66248d6ab12063084ad4b32a"})
//     .then( result => {
//         console.log(result);
//     })
//     .catch( err => {
//         console.log(err);
//     })

//-------------------------

// User.findOne({age: {$gt: 47}})
//     .then( result => {
//         console.log(result);
//     })
//     .catch( err => {
//         console.log(err);
//     })

//-------------------------

// User.findById({_id: '66248d6ab12063084ad4b32a'})
//     .then(result => {
//         console.log(result);
//     })
//     .catch( err => {
//         console.log(err);
//     })

/*finds a single document by its _id field is almost equivalent to { _id : id } */

// const id='66248d6ab12063084ad4b32a';

// User.findById(id)
//     .then(result => {
//         console.log(result);
//     })
//     .catch( err => {
//         console.log(err);
//     })

/*--------------------------( updateOne,updateMany,findOneAndUpdate and findByIdAndUpdate )---------------------------------------------------------------------------------------------------------------------------------------------*/

// User.updateOne({name:"Adam"},{age:55})
//     .then(result => {
//         console.log(result);
//     })
//     .catch(err => {
//         console.log(err);
//     })
//-------------------------
// User.updateMany({age: {$eq:50}},{age:28})
//     .then(result => {
//         console.log(result);
//     })
//     .catch(err => {
//         console.log(err);
//     })

//-------------------------
// User.findOneAndUpdate({age: {$eq: 29}},{age: 30},{new: true})
//     .then(result => {
//         console.log(result);
//     })
//     .catch(err => {
//         console.log(err);
//     })
//-------------------------
// User.findOneAndUpdate({name: "Peter"},{name:"Peter Parker"})
//     .then( (result) => {
//         console.log(result);
//     })
//     .catch(err => {
//         console.log(err);
//     })
//-------------------------
// User.findByIdAndUpdate({_id: '66248d6ab12063084ad4b32a'},{name:"Tonny Stark"})
//     .then( (result) => {
//         console.log(result);
//     })
//     .catch(err => {
//         console.log(err);
//     })

/*--------------------------( deleteOne,deleteMany,findOneAndDelete and findByIdAndDelete )---------------------------------------------------------------------------------------------------------------------------------------------*/

// User.deleteOne({name: "Eve"})
//     .then(res => {
//         console.log(res);
//     })
//     .catch(err => {
//         console.log(err);
//     })
//-------------------------
// User.findOneAndDelete({age: 55})
//     .then(res => {
//         console.log(res);
//     })
//     .catch(err => {
//         console.log(err)
//     })
//-------------------------
// User.findByIdAndDelete({_id: '66248d6ab12063084ad4b32c'})
//     .then(res => {
//         console.log(res);
//     })
//     .catch(err => {
//         console.log(err);
//     })



















