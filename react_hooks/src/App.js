import { useState } from "react";
//import "./styles.css";

const useInput = (initVal, validator) => {
  const [value, setValue] = useState(initVal);
  const onChange = (event) => {
    const {
      target: { value }
    } = event;
    let willUpdate = true;
    if (typeof validator === "function") {
      willUpdate = validator(value);
    }
    if (willUpdate) {
      setValue(value);
    }
  };
  return { value, onChange };
};

const App = () => {
  const maxLen = (value) => {
    if (value.length <= 10 && !value.includes("@")) {
      return true;
    }
    return false;
  };
  const name = useInput("Mr.", maxLen);
  return (
    <div className="App">
      <h1>Hello</h1>
      <input placeholder="Name" {...name} />
    </div>
  );
};
export default App;
