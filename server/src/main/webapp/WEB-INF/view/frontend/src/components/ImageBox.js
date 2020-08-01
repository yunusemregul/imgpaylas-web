import React, { useState } from "react";
import icon_profile from "../assets/images/icon_profile.png";

export default function ImageBox({ data }) {
  const [imageLoaded, setImageLoaded] = useState(false);

  return (
    <div className="imagebox">
      <div
        className="imagebox-imgbox"
        style={{ backgroundColor: "rgba(" + data.col + ", 1)" }} // fotoğraf yüklenene kadar temsilen fotoğrafın ortalama rengini gösteriyoruz
      >
        <img
          className="imagebox-img"
          src={data.url}
          loading="lazy"
          alt={data.desc}
          height={
            // fotoğraf daha yüklenmediğinde fotoğrafın yüksekliğini temsilen gösteriyoruz
            // fotoğraf yüklendiğinde layoutta hareketlilik olmasın diye
            !imageLoaded && data.h / (data.w / (window.innerWidth / 3.333))
          }
          style={{ width: "100%" }}
          onLoad={() => {
            setImageLoaded(true);
          }}
        />
      </div>
      <div className="imagebox-desc">
        {data.desc}
        <br />
        <img
          src={icon_profile}
          width="20px"
          style={{ transform: "translateY(4px)", marginRight: "6px" }}
          alt=""
        />
        {data.uname}
      </div>
    </div>
  );
}
