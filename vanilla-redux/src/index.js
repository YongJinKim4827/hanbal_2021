import {createStore} from "redux";

const form = document.querySelector("form");
const input = document.querySelector("input");
const ul = document.querySelector("ul");

const ADD_TODO = "ADD_TODO";
const DELETE_TODO = "DELETE_TODO";

const reducer = (state = [], action) => {
  switch(action.type){
    case ADD_TODO : 
      return [ {text : action.text, id : Date.now()}, ...state ];//ES6 Spread
    case DELETE_TODO : 
      return state.filter(toDos => toDos.id !== action.id);
    default : 
      return state;
  }
};


const store = createStore(reducer);
const toDos = [];

const paintToDos = () => {
  const toDos = store.getState();
  ul.innerText = "";
  toDos.forEach(toDo => {
    const li = document.createElement("li");
    const btn = document.createElement("button");
    btn.innerText = "Del";
    btn.addEventListener("click", dispatchDeleteToDo);
    li.id = toDo.id
    li.innerText = toDo.text;
    li.appendChild(btn);
    ul.appendChild(li);
  })
};

store.subscribe(paintToDos);

const dispatchAddToDo = (text) => {
  store.dispatch(addToDo(text));
}

//action creator
const addToDo = (text) => {
  return {
    type : ADD_TODO, 
    text
  }
}
const dispatchDeleteToDo = (e) => {
  const id = parseInt(e.target.parentNode.id);
  store.dispatch(deleteToDo(id));
}

//action creator
const deleteToDo = (id) => {
  return {
    type : DELETE_TODO, 
    id
  }
}

const onSubmit = (e) => {
  e.preventDefault();
  const toDo = input.value;
  input.value = "";
  dispatchAddToDo(toDo)
}

form.addEventListener("submit", onSubmit);