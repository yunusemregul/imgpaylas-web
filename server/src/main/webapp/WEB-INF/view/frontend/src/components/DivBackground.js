import React from "react";
import content from "../assets/images/content.png";

const imageStyle = {
  overflow: "hidden",
  backgroundImage: "url(" + content + ")",
  backgroundRepeat: "no-repeat",
  backgroundSize: "cover",
};

export default function DivBackground(props) {
  return (
    <div
      className="row-fill"
      style={props.color ? { color: props.color } : imageStyle}
    >
      {props.children}
    </div>
  );
}
