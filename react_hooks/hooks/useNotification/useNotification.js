import { useCallback, useEffect, useRef, useState } from "react";
import "./styles.css";

const useNotification = (title, option) => {
  if (!("Notification" in window)) {
    return;
  }

  const fireNotif = () => {
    if (Notification.permission !== "granted") {
      Notification.requestPermission().then((permission) => {
        if (permission === "granted") {
          new Notification(title, option);
        } else {
          return;
        }
      });
    } else {
      new Notification(title, option);
    }
  };
  return fireNotif;
};
const UseNotification = () => {
  const triggerNotif = useNotification("Can I steal your kimchi", {
    body: "I Love Kimchi"
  });
  return (
    <div>
      <button onClick={triggerNotif}>Hi</button>
    </div>
  );
};

export default UseNotification;
