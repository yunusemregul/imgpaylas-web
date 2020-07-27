import React from "react";
import content from "./assets/content.png";

export default function DivBackground(props) {
  return (
    <div
      className="row-fill"
      style={{
        overflow: "hidden",
        backgroundImage: "url(" + content + ")",
      }}
    >
      {props.children}
    </div>
  );
}
