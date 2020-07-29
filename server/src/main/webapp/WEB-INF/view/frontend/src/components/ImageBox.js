import React from "react";
import icon_profile from "../assets/images/icon_profile.png";

export default function ImageBox(props) {
  return (
    <div className="imagebox">
      <div className="imagebox-imgbox">
        <img
          src={props.img}
          loading="lazy"
          alt={props.desc}
          style={{ width: "100%" }}
        />
      </div>
      <div className="imagebox-desc">
        {props.desc}
        <br />
        <img
          src={icon_profile}
          width="20px"
          style={{ transform: "translateY(4px)", marginRight: "6px" }}
        />
        {props.user}
      </div>
    </div>
  );
}
