const mongoose = require("mongoose");

main()
    .then(() => {
        console.log("connection successful");
    })
    .catch(err => {
        console.log(err);
    })

async function main() {
    await mongoose.connect("mongodb://127.0.0.1:27017/amazon");
}

/*----------------------------------------------------- */
// const bookSchema = new mongoose.Schema({
//     title: {
//         type: String,
//         required: true,
//     },
//     author: {
//         type: String,
//     },
//     price: {
//         type: Number,
//     },
// })

// const Book = mongoose.model("Book",bookSchema);

// const book1 = new Book({
//     title:"Mathematics",
//     author:"RD SHARMA",
//     price: 1200
// });
// book1.save()
//     .then(res=>{
//         console.log(res);
//     })
//     .catch(err=>{
//         console.log(err);
//     })

// const book2 = new Book({
//     title:"iron man",
//     author:"robert dowry jr.",
//     price: "800",     // in casting string is convert into number 
// })
// book2.save()
//     .then(res => {
//         console.log(res);
//     })
//     .catch(err => {
//         console.log(err);
//     })

// const book3 = new Book({
//     title:"Spiderman",
//     author:"Peter Parker",
//     price: 2400
// })

// book3.save()
//     .then(res => {
//         console.log(res);
//     })
//     .catch(err=>{
//         console.log(err);
//     })

/*-------------------------------------------------------*/


const bookSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true, 
        unique:true,
        lowercase:true,
        trim:true,
    },
    author: {
        type: String,
        immutable: [true,"you cannot changed name of author"],
        minLength:5,
        maxLength:[20,"maximum word length should be 20"], 
        uppercase:true,
    },
    price: {
        type: Number,
        min:100,
        max:[10000,"price not greater than 10,000 rupees(gagan)"],
       
    },
    discount: {
        type: Number,
        default: 10,
    },
    category: {
        type: String,
        enum: ["fiction","non-fiction"],
    },
    favourite: {
        type: String,
        enum: {
            values: ["marvel","dc","disney","pixar"],
            message: `{value}  is not supported,you should choose between marvel,dc,disney,pixar`
        }
    },
    genre: {
        type: [String]
    },
})

//-------------------------

const Comic = mongoose.model("Comic",bookSchema);

//-------------------------

// const comic1 = Comic({
//     title:"  IRONMAN  ",
//     author: "robert dowry jr.",
//     price: 1000,
//     category:"fiction",
//     favourite:"marvel",
//     genre:"tonny Stark",
// })
// .save()
// .then(res =>{
//     console.log(res);
// })
// .catch(err =>{
//     console.log(err);
// })

/*---------------(validation rules work only in insertion not in updation,because 100000 is not valid for insertion)-------------------------------- */
/*-------------------------------------------------------------- */
// Comic.updateOne({title:"ironman"},{price: 100000})
// .then(res =>{
//     console.log(res);
// })
// .catch(err =>{
//     console.log(err);
// })

/*---------------(if we want that rules are also work for updation)-------------------------------- */
/*-------------------( {runValidators: true }:-Update validators validate the update operation against the model's schema)------------------------------------------- */

// Comic.updateOne({title:"ironman"},{price: 100000},{runValidators:true})
// .then(res =>{
//     console.log(res);
// })
// .catch(err =>{
//     console.log(err);
// })

/*---------------(Handling Errors in Validations)-------------------------------- */


Comic.updateOne({title:"ironman"},{price: 50000},{runValidators:true})
.then(res =>{
    console.log(res);
})
.catch(err =>{
    console.log(err.errors.price.properties.message);
})

