import { useEffect, useRef, useState } from "react";
//import "./styles.css";

const useClick = (onClick) => {
  if (onClick !== "function") {
    return;
  }
  const el = useRef();
  useEffect(() => {
    if (el.current) {
      el.current.addEventListener("click", onClick);
    }
    return () => {
      if (el.current) {
        el.current.removeEventListener("click", onClick);
      }
    };
  }, []);
  return el;
};
const App = () => {
  //const ref = useRef(); /*getElementByID와 유사함*/
  const sayHello = () => console.log("say Hello");
  const title = useClick(sayHello);
  return (
    <div className="App">
      <h1 ref={title}>Hi</h1>
    </div>
  );
};
export default App;
