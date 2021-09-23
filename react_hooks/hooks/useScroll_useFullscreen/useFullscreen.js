import { useCallback, useEffect, useRef, useState } from "react";
import "./styles.css";

const useFullscreen = (callback) => {
  const element = useRef();
  const triggerFull = () => {
    if (element.current) {
      element.current.requestFullscreen();
      if (callback && typeof callback === "function") {
        callback(true);
      }
    }
  };

  const exitFull = () => {
    document.exitFullscreen();
    if (callback && typeof callback === "function") {
      callback(false);
    }
  };
  return { element, triggerFull, exitFull };
};

const UseFullscreen = () => {
  const onFullS = (isFull) => {
    console.log(isFull ? "We are Full" : "We are Small");
  };
  const { element, triggerFull, exitFull } = useFullscreen(onFullS);
  return (
    <div>
      <div ref={element}>
        <img src="https://p4.wallpaperbetter.com/wallpaper/215/616/962/tv-show-game-of-thrones-jon-snow-kit-harington-wallpaper-preview.jpg" />
        <button onClick={exitFull}>Exit FullScreen</button>
      </div>
      <button onClick={triggerFull}>Make FullScreen</button>
    </div>
  );
};

export default UseFullscreen;
