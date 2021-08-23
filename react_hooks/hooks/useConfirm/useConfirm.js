//import "./styles.css";

//useState, useEffect를 사용하지않아서 Hooks이 아님
const useConfirm = (msg, onConfirm, onCancel) => {
    //Alert
    if (onConfirm || typeof onConfirm !== "function") {
      return;
    }
  
    if (onCancel && typeof onCancel !== "function") {
        return;
      }

    const confirmAction = () => {
      if (window.confirm(msg)) {
        onConfirm();
      } else {
        onCancel();
      }
    };
    return confirmAction;
  };
  const UseConfirm = () => {
    const deleteWorld = () => {
      console.log("Delete the world.....");
    };
    const abort = () => {
      console.log("Abort");
    };
  
    const confirmDelete = useConfirm("Are You Sure...??", deleteWorld, abort);
    return (
      <div>
        <button onClick={confirmDelete}>Delete the World</button>
      </div>
    );
  };
  
  export default UseConfirm;
  