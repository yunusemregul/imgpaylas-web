import React from "react";

export default function ImageBox(props) {
  return (
    <div className="imagebox">
      <div className="imagebox-imgbox">
        <img src={props.img} alt={props.desc} style={{ width: "100%" }} />
      </div>
      <div className="imagebox-desc">{props.desc}</div>
    </div>
  );
}
