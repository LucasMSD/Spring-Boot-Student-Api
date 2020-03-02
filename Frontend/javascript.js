var idInputElement = document.getElementById('id')
var nameInputElement = document.getElementById('name')
var courseInputElement = document.getElementById('course')
var buttonSubmitElement = document.getElementById('submit')

var fields = {idInputElement, nameInputElement, courseInputElement}

buttonSubmitElement.onclick = function () {
    if (allFieldsAreFilled(fields)) {
        postStudentRequest()
    } else {
        alert("Please, fill all the fields to submit them")
    }
}



postStudentRequest = async () => {
    await axios.post('localhost:8080/students', {
        id: Number(idInputElement.value),
        name: nameInputElement.value,
        course: courseInputElement.value
    })
    .then(function (response) {
        console.log(response)
    })
    .catch(function (error){
        console.error(error)
    })
}

function allFieldsAreFilled(fields) {
    isAllOk = true
    for (var field in fields) {
        if (isEmpty(field.value)) {
            isAllOk = !isAllOk
        }
    }

    return isAllOk
}

function isEmpty(field) {
    if (field === '') {
        return true
    } else {
        return false
    }
}