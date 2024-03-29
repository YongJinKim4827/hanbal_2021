import { useEffect } from "react";
import "./styles.css";

const useBeforeLeave = (onBefore) => {
  if (typeof onBefore !== "function") {
    return;
  }
  const handle = (event) => {
    const { clientY } = event;
    if (clientY <= 0) {
      onBefore();
    }
  };
  useEffect(() => {
    document.addEventListener("mouseleave", handle);
    return () => document.removeEventListener("mouseleave", handle);
  }, []);
};
const UseBeforeLeave = () => {
  const begForLife = () => console.log("Pis dont leave");
  useBeforeLeave(begForLife);
  return (
    <div>
      <h1>Hello</h1>
    </div>
  );
};

export default UseBeforeLeave;
