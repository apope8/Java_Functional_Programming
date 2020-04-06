
function hello(firstName, lastName, callBack) {
    console.log(firstName);
    if (lastName){
        console.log(lastName)
    }
    else {
        callBack;
    }
}