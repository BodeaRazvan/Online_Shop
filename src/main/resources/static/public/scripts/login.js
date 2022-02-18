// const usernameInput = document.getElementById("username");
// const paswordInput = document.getElementById("password");
// const cancelButton = document.getElementById("cancelButton");
// const errorLabel = document.getElementById('errorLabel');
//
// cancelButton.addEventListener("click",onpressedCancelButton);
//
// usernameInput.addEventListener("input" ,(e) => {
//     onTypeInput("Username",usernameInput.value);
// });
// paswordInput.addEventListener("input" ,(e) => {
//     onTypeInput("Password",paswordInput.value);
// });
//
// function onTypeInput(sourceInput,input){
//     errorLabel.innerHTML = "";
//     if (input === ""){
//         errorLabel.innerHTML = sourceInput + " input is empty"
//     }
// }


// function onpressedLoginButton(e){
//     if(!(usernameInput.value === "") && !(paswordInput.value=== "") ) {
//         $.ajax({
//             type: "GET",
//             url: "/loginCheck/" + usernameInput.value + "," + paswordInput.value,
//             timeout: 100000,
//             success: function (response) {
//                 console.log("SUCCESS: ");
//                 console.log(response);
//             },
//             error: function (e) {
//                 console.log("ERROR: ", e);
//             },
//             done: function (e) {
//                 console.log("DONE");
//             }
//         });
//     }
// }

// function onpressedCancelButton(e){
//     usernameInput.value = "";
//     paswordInput.value = "";
// }
