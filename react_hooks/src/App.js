import { useEffect, useState } from "react";
//import "./styles.css";

const useTitle = (initTitle) => {
  const [title, setTitle] = useState(initTitle);
  const updateTitle = () => {
    const htmlTitle = document.querySelector("title");
    htmlTitle.innerText = title;
  };
  useEffect(updateTitle, [title]);
  return setTitle;
};
const App = () => {
  const titleUpdater = useTitle("Loading....");
  setTimeout(() => titleUpdater("Home"), 5000);
  return (
    <div className="App">
      <div>Hi</div>
    </div>
  );
};
export default App;
