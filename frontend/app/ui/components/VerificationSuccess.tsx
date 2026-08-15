import { CircleCheckBig, ShoppingCart } from "lucide-react";

export function VerificationSuccess() {
  return (
    <div className="flex flex-col items-center justify-between py-5 h-52">
      <div className="flex flex-col items-center justify-center">
        <CircleCheckBig className="text-lime-500 w-10 h-10" />
        <span className="text-3xl">Verified!</span>
      </div>

      <button className="flex bg-black items-center gap-5 p-3 px-8 rounded-4xl">
        <ShoppingCart className="text-white" />
        <span className="text-white">Browse Items!</span>
      </button>
    </div>
  );
}
