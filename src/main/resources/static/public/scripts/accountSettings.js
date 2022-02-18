const defaultScene = document.getElementById("defaultScene").innerHTML;
const usernameScene = document.getElementById("usernameScene").innerHTML;
const passwordScene = document.getElementById("passwordScene").innerHTML;

const mainDiv = document.getElementById('mainDiv');
let changePasswordButton = null;
let changeUsernameButton = null;
let cancelButton = null;
uploadDefaultScene();

function initialize(state){
    switch(state){
        case 0 :
            changePasswordButton = document.getElementById('changePasswordButton');
            changeUsernameButton = document.getElementById("changeUsernameButton")
            changeUsernameButton.addEventListener('click',uploadChangeUsernameScene);
            changePasswordButton.addEventListener('click',uploadChangePasswordScene);
            break;
        case 1 :
            // let saveButton = document.getElementById("saveButton");
            cancelButton = document.getElementById("cancelButton1");
            cancelButton.addEventListener('click',uploadDefaultScene);
            break;
        case 2 :
            // let saveButton = document.getElementById("saveButton");
            cancelButton = document.getElementById("cancelButton2");
            cancelButton.addEventListener('click',uploadDefaultScene);
            break;
    }
}

function uploadDefaultScene(){
    mainDiv.innerHTML = defaultScene;
    initialize(0);
}
function uploadChangeUsernameScene(){
    mainDiv.innerHTML = usernameScene;
    initialize(1);
}
function uploadChangePasswordScene(){
    mainDiv.innerHTML = passwordScene;
    initialize(2);
}