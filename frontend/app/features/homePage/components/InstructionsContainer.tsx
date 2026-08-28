import { InstructionsComponent } from "./Instructions";
import { CircleDollarSign, Handshake, ShieldCheck } from "lucide-react";

export function InstructionsContainer() {
  return (
    <div className="flex md:flex-row flex-col gap-5 justify-around bg-gray-300 p-10">
      <InstructionsComponent
        icon={ShieldCheck}
        title="Verified Profiles"
        description="All sellers are students with a verified .ac.uk email"
      />
      <InstructionsComponent
        icon={Handshake}
        title="Safe Pickups"
        description="Pickup at safe designated locations like student unions"
      />
      <InstructionsComponent
        icon={CircleDollarSign}
        title="No Fees"
        description="You keep 100% of the listing price."
      />
    </div>
  );
}
