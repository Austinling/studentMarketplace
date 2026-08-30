import { TopNavBar } from "../features/auth/components/TopNavBar";
import { RevenueCard } from "../features/dashboard/components/RevenueCard";

export default function Dashboard() {
  return (
    <div className={`bg-gray-300 p-10 h-dvh ]`}>
      <div className="grid grid-cols-2 lg:grid-cols-4 gap-5">
        <RevenueCard />
        <RevenueCard />
        <RevenueCard />
        <RevenueCard />
      </div>
    </div>
  );
}
