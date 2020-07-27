import React from "react";
import content from "../assets/images/content.png";

export default function DivBackground(props) {
  return (
    <div
      className="row-fill"
      style={{
        overflow: "hidden",
        backgroundImage: "url(" + content + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "cover",
      }}
    >
      {props.children}
    </div>
  );
}
